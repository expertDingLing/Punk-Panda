var _ = require('lodash');
var VCardParser = require('oniyi-vcard-parser');

var CONST = require('../../../consts');
var U = require('../../../libs/utils.js');
var LoginUserManager = require('../../../libs/loginUserManager.js');
var Message = require('../../../Models/message.js');
var WebAPIManager = require('../../../libs/webAPIManager');
var UrlGenerator = require('../../../libs/urlGenerator');
var socketIOManager = require('../../../libs/socketIOManager');
var Settings = require('../../../libs/Settings');

function CellGenerator(options){
    this.parentView = options.view;
    
    // loading templates
    this.messageTemplate = require('./MessageCells/Message.hbs');
    this.stickerTemplate = require('./MessageCells/Sticker.hbs');
    this.fileUploadingTemplate = require('./MessageCells/FileUploading.hbs');
    this.userStateChangeTemplate = require('./MessageCells/UserStateChange.hbs');
    this.fileTemplate = require('./MessageCells/File.hbs');
    this.thumbTemplate = require('./MessageCells/Thumbnail.hbs');
    this.typingTemplate = require('./MessageCells/Typing.hbs');
    this.deletedTemplate = require('./MessageCells/DeletedMessage.hbs');
    this.locationTemplate = require('./MessageCells/Location.hbs');
    this.contactTemplate = require('./MessageCells/Contact.hbs');
};

CellGenerator.prototype.parentView = null;
CellGenerator.prototype.generate = function(messageModel){

    var flatData = {};

    _.forEach(messageModel.attributes, function(val, key) {
        flatData[key] = val;
    });

    _.forEach(messageModel.get('user').attributes, function(val, key) {
    
        if(key == 'created')
            return;
            
        if(key == 'id')
            return;
            
        flatData[key] = val;
    });
    
    if(messageModel.get('type') == CONST.MESSAGE_TYPE_TEXT){
        flatData.message = U.escapeHtml(flatData.message);
        flatData.message = flatData.message.replace(new RegExp('  ','g'), '&nbsp;&nbsp;');
        flatData.message = flatData.message.replace(new RegExp('\t','g'), '&nbsp;&nbsp;&nbsp;&nbsp;');
        flatData.message = flatData.message.replace(new RegExp('\r?\n','g'), '<br/>');
        flatData.message = U.contentExtract(flatData.message);
    }
    
    if(flatData.userID == LoginUserManager.user.get('id') && Settings.options.useBothSide){
        flatData.isMine = 'mine';
        flatData.isMainForIf = 1;
    }else{
        flatData.isMine = 'other';
    }
    
    var html = '';
        
    if(messageModel.get('deleted') != 0){

        html = this.deletedTemplate(flatData);
        
    } else {
    
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_TEXT)
            html = this.messageTemplate(flatData);
        
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_FILE){
            
            console.log("flatData",flatData);
             
            if(!_.isUndefined(flatData.file.thumb)){
                
                // thumbnail exists
                //flatData.downloadURL = 'http://192.168.1.5:8080/img/ipad-art-wide-AVATAR2-420x0.jpg';
                flatData.downloadURL = UrlGenerator.downloadFile(flatData.file.file.id);
                flatData.thumbURL = UrlGenerator.downloadFile(flatData.file.thumb.id);
                html = this.thumbTemplate(flatData);
                                     
            }else{
    
                flatData.file.file.size = Math.floor(flatData.file.file.size / 1024 / 1024 * 100) / 100; // MB
                flatData.downloadURL = UrlGenerator.downloadFile(flatData.file.file.id);
                
                html = this.fileTemplate(flatData);
                
            }
            
        }

        if(messageModel.get('type') == CONST.MESSAGE_TYPE_LOCATION){
            html = this.locationTemplate(flatData);
        }
        
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_CONTACT){

            var vcard = new VCardParser({
                vCardToJSONAttributeMapping: {
                    'FN': 'name',
                    'TEL;HOME': 'telhome',
                    'TEL;CELL': 'telcell'
                }
            });

            var vcardObject = vcard.toObject(flatData.message);
            
            flatData.vcard = vcardObject;
            html = this.contactTemplate(flatData);
        }
        
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_STICKER)
            html = this.stickerTemplate(flatData);
            
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_FILE_UPLOADIND){
            
            if(messageModel.get('isUploading') == 1){
                html = this.fileUploadingTemplate(flatData);                
            }
            
        }
    
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_TYPING){
            
            flatData.message = flatData.name + " is typing...";
            html = this.typingTemplate(flatData);
    
        }
            
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_NEW_USER){
            
            flatData.message = flatData.name + " joined to conversation. ";
            html = this.userStateChangeTemplate(flatData);
    
        }
    
        if(messageModel.get('type') == CONST.MESSAGE_TYPE_USER_LEAVE){
            
            flatData.message = flatData.name + " left from conversation. ";
            html = this.userStateChangeTemplate(flatData);
    
        }
        

        
    }

    return html;

};


module.exports = CellGenerator;


    
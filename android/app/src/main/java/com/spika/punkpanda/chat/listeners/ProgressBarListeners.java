package com.spika.punkpanda.chat.listeners;

public interface ProgressBarListeners {
	public void onSetMax(long total);
	public void onProgress(long current);
	public void onFinish();
}

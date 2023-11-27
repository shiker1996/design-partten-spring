package com.example.designpattern.Builder;

import com.example.designpattern.Builder.framework.Builder;
import com.example.designpattern.Builder.framework.BuilderName;
import org.springframework.stereotype.Component;

/**
 * 使用director的内容打印文本文档
 * @author shiker96
 *
 */
@Component
@BuilderName("textBuilder")
public class TextBuilder implements Builder {

	private StringBuffer buffer = new StringBuffer();

	@Override
	public void makeTitle(String title) {
		// TODO Auto-generated method stub
		buffer.append("======================\n");
		buffer.append("[" + title + "]\n");
		buffer.append("\n");

	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		buffer.append("[]" + str + "\n");
		buffer.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.length; i++) {
			buffer.append("   ." + items[i] + "\n");
		}
		buffer.append("\n");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		buffer.append("================\n");
	}

	public String getResult() {
		return buffer.toString();
	}
}

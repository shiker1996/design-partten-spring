package com.example.designpattern.Visitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Iterator;
/**
 * 显示文件和文件夹一览
 * @author shiker96
 *
 */
@Component
@Slf4j
public class ListVisitor extends Visitor {

	private String currentdir = "";
	@Override
	public void visit(VFile VFile) {
		// TODO Auto-generated method stub
        log.info(currentdir+"/"+ VFile);
	}

	@Override
	public void visit(VDirectory VDirectory) {
		// TODO Auto-generated method stub
        log.info(currentdir+"/"+ VDirectory);
        String savedir = currentdir;
        currentdir = currentdir+"/"+ VDirectory.getName();
        Iterator<Entry> it = VDirectory.iterator();
        while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.accept(this);
		}
        currentdir = savedir;
	}

}

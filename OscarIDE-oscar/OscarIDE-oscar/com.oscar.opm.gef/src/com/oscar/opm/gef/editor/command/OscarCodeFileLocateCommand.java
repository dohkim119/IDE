package com.oscar.opm.gef.editor.command;

import java.io.File;

import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OscarCode;

public class OscarCodeFileLocateCommand extends Command {
	private OscarCode code;
	private File newfile;
	private File oldfile;
	
	@Override
	public boolean canExecute() {
	    return code != null && newfile != null;
	}
	
	@Override
	public void execute() {
		oldfile = code.getCodefile();
		code.setCodefile(newfile);
	}
	
	@Override
	public void undo() {
		code.setCodefile(oldfile);
	}
	
	
	public void setFile(final File file) {
		this.newfile = file;
	}
	
	public void setModel(final OscarCode code) {
		this.code = code;
	}
	
}

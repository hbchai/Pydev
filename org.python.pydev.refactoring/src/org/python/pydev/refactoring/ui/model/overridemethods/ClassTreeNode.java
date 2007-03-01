package org.python.pydev.refactoring.ui.model.overridemethods;

import java.util.ArrayList;
import java.util.List;

import org.python.pydev.refactoring.ast.adapters.ClassDefAdapter;
import org.python.pydev.refactoring.ast.adapters.FunctionDefAdapter;
import org.python.pydev.refactoring.ui.model.tree.ITreeNode;
import org.python.pydev.refactoring.ui.model.tree.TreeNodeSimple;

public class ClassTreeNode extends TreeNodeSimple<ClassDefAdapter> {

	public ClassTreeNode(ClassDefAdapter adapter) {
		super(null, adapter);
	}

	@Override
	public Object[] getChildren() {
		List<ITreeNode> children = new ArrayList<ITreeNode>();
		for (FunctionDefAdapter function : this.adapter.getFunctionsInitFiltered()) {
			children.add(new FunctionTreeNode(this, function));
		}
		return children.toArray();
	}

	@Override
	public String getImageName() {
		return ITreeNode.NODE_CLASS;
	}

}
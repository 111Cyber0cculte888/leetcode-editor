package com.shuzijun.leetcode.plugin.actions;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.shuzijun.leetcode.plugin.manager.CodeManager;
import com.shuzijun.leetcode.plugin.manager.ViewManager;
import com.shuzijun.leetcode.plugin.model.Config;
import com.shuzijun.leetcode.plugin.model.Question;
import com.shuzijun.leetcode.plugin.utils.DataKeys;
import com.shuzijun.leetcode.plugin.utils.URLUtils;
import com.shuzijun.leetcode.plugin.window.WindowFactory;

import javax.swing.*;

public class FindSolutionAction extends AbstractAsynAction {
    @Override
    public void perform(AnActionEvent anActionEvent, Config config) {
        JTree tree = WindowFactory.getDataContext(anActionEvent.getProject()).getData(DataKeys.LEETCODE_PROJECTS_TREE);
        Question question = ViewManager.getTreeQuestion(tree);
        if (question == null) {
            return;
        }
//        CodeManager.RuncodeCode(question);
        BrowserUtil.browse("https://raw.githubusercontent.com/fishercoder1534/Leetcode/master/src/main/java/com/fishercoder/solutions/_" + question.getQuestionId() + ".java");


    }
}


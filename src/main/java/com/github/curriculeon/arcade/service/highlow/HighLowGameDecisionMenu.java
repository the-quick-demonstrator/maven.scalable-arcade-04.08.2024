package com.github.curriculeon.arcade.service.highlow;

import com.github.curriculeon.arcade.lib.utils.AbstractDecisionMenu;

/**
 * Created by leon on 6/27/2020.
 */
public class HighLowGameDecisionMenu extends AbstractDecisionMenu<HighLowGameDecision> {
    public HighLowGameDecisionMenu() {
        super(HighLowGameDecision.values());
    }
}

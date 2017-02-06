package com.srug.mobile.todo;

import com.srug.mobile.todo.common.ContextView;
import com.srug.mobile.todo.common.PresenterOps;

public interface MVP {

    interface MainRequiredViewOps extends ContextView {

    }

    interface MainProvidedPresenterOps extends PresenterOps<MainRequiredViewOps> {

    }
}

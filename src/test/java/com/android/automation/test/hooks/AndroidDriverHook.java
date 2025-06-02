package com.android.automation.test.hooks;

import com.android.automation.test.drivers.AndroidDriverInit;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class AndroidDriverHook {

  @Autowired
  AndroidDriverInit androidDriverInit;
  @Before
  public void init(){
    androidDriverInit.initialize();
  }

}

/**
 */
package br.com.devnagui.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.devnagui.project.fiscal.ManagerUserTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({ ManagerUserTestsSuite.class })
public class ProjectWebTestSuite {

}

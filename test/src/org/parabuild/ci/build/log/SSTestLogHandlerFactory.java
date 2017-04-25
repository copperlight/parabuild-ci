/*
 * Parabuild CI licenses this file to You under the LGPL 2.1
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      https://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.parabuild.ci.build.log;

import junit.framework.TestSuite;
import org.parabuild.ci.ServersideTestCase;
import org.parabuild.ci.TestHelper;

import org.parabuild.ci.configuration.ConfigurationManager;
import org.parabuild.ci.error.ErrorManager;
import org.parabuild.ci.error.ErrorManagerFactory;
import org.parabuild.ci.remote.Agent;
import org.parabuild.ci.remote.AgentManager;


public class SSTestLogHandlerFactory extends ServersideTestCase {

  protected static final int TEST_SEQUENCE_RUN_ID = 1;
  protected static final int TEST_BUILD_ID = TestHelper.TEST_CVS_VALID_BUILD_ID;

  private ConfigurationManager cm;
  private Agent agent;
  private ErrorManager errorManager;


  public void test_makeLogHandler() throws Exception {
    final LogHandler logHandler = LogHandlerFactory.makeLogHandler(agent, TEST_SEQUENCE_RUN_ID);
    assertTrue(logHandler instanceof CompositeLogHandler);
  }


  public static TestSuite suite() {
    return new TestSuite(SSTestLogHandlerFactory.class);
  }


  protected void setUp() throws Exception {
    super.setUp();
    this.cm = ConfigurationManager.getInstance();
    this.agent = AgentManager.getInstance().getNextLiveAgent(TEST_BUILD_ID);
    this.errorManager = ErrorManagerFactory.getErrorManager();
    this.errorManager.clearAllActiveErrors();
    System.setProperty("parabuild.print.stacktrace", "true");
  }


  protected void tearDown() throws Exception {
    assertEquals("Number of errors", 0, errorManager.errorCount());
    super.tearDown();
  }


  public SSTestLogHandlerFactory(final String s) {
    super(s);
  }
}

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
package org.parabuild.ci.webui;

import junit.framework.*;

import org.parabuild.ci.ServersideTestCase;
import org.parabuild.ci.TestHelper;
import org.parabuild.ci.configuration.*;
import org.parabuild.ci.webui.common.*;

public final class SSTestParallelBuildRunListPanel extends ServersideTestCase {

  private BuildRunURLFactory buildRunLinkFactory;


  public void test_createLeading() {
    final ParallelBuildRunListPanel panel = new ParallelBuildRunListPanel(ConfigurationManager.getInstance().getBuildRun(TestHelper.LEADING_BUILD_RUN_ID), buildRunLinkFactory);
  }


  public void test_createDependent() {
    final ParallelBuildRunListPanel dd1 = new ParallelBuildRunListPanel(ConfigurationManager.getInstance().getBuildRun(TestHelper.DEPENDENT_BUILD_RUN_ID_1), buildRunLinkFactory);
    final ParallelBuildRunListPanel dd2 = new ParallelBuildRunListPanel(ConfigurationManager.getInstance().getBuildRun(TestHelper.DEPENDENT_BUILD_RUN_ID_2), buildRunLinkFactory);
  }


  protected void setUp() throws Exception {
    buildRunLinkFactory = new StandardBuildRunURLFactory(Pages.BUILD_CHANGES);
    super.setUp();
  }


  public static TestSuite suite() {
    return new TestSuite(SSTestParallelBuildRunListPanel.class);
  }


  public SSTestParallelBuildRunListPanel(final String s) {
    super(s);
  }
}

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
package org.parabuild.ci.webui.result;

import org.apache.cactus.*;

import junit.framework.*;

import org.parabuild.ci.TestHelper;

/**
 * Tests PublishedResultsPage
 *
 * @see PublishedResultsPage
 */
public class SSTestPublishedResultsPage extends ServletTestCase {

  public SSTestPublishedResultsPage(final String s) {
    super(s);
  }


  /**
   * Makes sure that page responds
   */
  public void testPageSmokes() throws Exception {
    TestHelper.assertPageSmokes("/parabuild/result/groups.htm", "Result Groups");
  }


  /**
   * Required by JUnit
   */
  public static TestSuite suite() {
    return new TestSuite(SSTestPublishedResultsPage.class);
  }
}

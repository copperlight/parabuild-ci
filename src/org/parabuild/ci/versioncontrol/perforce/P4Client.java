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
package org.parabuild.ci.versioncontrol.perforce;

import org.apache.log4j.Logger;

/**
 * Holds P4 client.
 * <p/>
 *
 * @author Slava Imeshev
 * @since Nov 5, 2009 9:31:10 PM
 */
public final class P4Client {

  /**
   * Logger.
   *
   * @noinspection UNUSED_SYMBOL,UnusedDeclaration
   */
  private static final Logger LOG = Logger.getLogger(P4Client.class); // NOPMD

  private final String viewLines;


  public P4Client(final String viewLines) {

    this.viewLines = viewLines;
  }


  public String getViewLines() {
    return viewLines;
  }


  public String toString() {
    return "P4Client{" +
            "view='" + viewLines + '\'' +
            '}';
  }
}

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

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.parabuild.ci.common.StringUtils;
import org.parabuild.ci.object.ChangeList;
import org.parabuild.ci.object.SimpleChange;
import org.parabuild.ci.webui.common.WebuiUtils;

/**
 * ViewVC SVN-specific implementation of {@link ChangeURLFactory}.
 */
public final class ViewSVNChangeURLFactory implements ChangeURLFactory {

  /** @noinspection UNUSED_SYMBOL,UnusedDeclaration*/
  private static final Log log = LogFactory.getLog(ViewSVNChangeURLFactory.class); // NOPMD

  private String url = null;
  private boolean showRevision = false;
  private final String viewcvsRoot;


  public ViewSVNChangeURLFactory(final String viewcvsURL) {
    this(viewcvsURL, "", false);
  }


  public ViewSVNChangeURLFactory(final String viewcvsURL, final String viewcvsRoot) {
    this(viewcvsURL, viewcvsRoot, false);
  }


  public ViewSVNChangeURLFactory(final String viewcvsURL, final String viewcvsRoot, final boolean showRevision) {
    this.viewcvsRoot = viewcvsRoot;
    this.url = viewcvsURL;
    this.showRevision = showRevision;
  }


  /**
   * Produces {@link ChangeURL} from the given change.
   *
   * @param change
   *
   * @return created {@link ChangeURL} object.
   */
  public ChangeURL makeChangeFileURL(final SimpleChange change) {
    return new ChangeURLImpl(makeFileURL(change), change.getFilePath());
  }


  public ChangeURL makeChangeRevisionURL(final SimpleChange change) {
    return new ChangeURLImpl(makeFileURL(change), "");
  }


  /**
   * Produces {@link ChangeURL} from the given change.
   *
   * @param changeList
   *
   * @return created {@link ChangeURL} object or null if URL
   *  creation for change lists is not supported.
   */
  public ChangeURL makeChangeListNumberURL(final ChangeList changeList) {
    //
    // Example:
    //   http://svn.apache.org/viewvc?diff_format=h&view=rev&revision=480585
    //
    final Properties params = new Properties();
    params.setProperty("diff_format", "h");
    params.setProperty("view", "rev");
    params.setProperty("revision", changeList.getNumber());
    return new ChangeURLImpl(makeURL("", params), changeList.getNumber());
  }


  /**
   * Helper method.
   *
   * @param change
   *
   * @return String base URL
   */
  private String makeFileURL(final SimpleChange change) {
    // a typical Subversion file URL looks like this:
    // http://svn.apache.org/viewvc/jakarta/poi/trunk/src/scratchpad/src/org/apache/poi/hwpf/model/FIBFieldHandler.java?diff_format=h&view=markup&pathrev=480585
    // compose paramter list
    final Properties params = new Properties();
    if (showRevision) {
      //  NOTE: vimeshev - 2005-01-15 - see #815 "Remove version
      // information from ViewCVS links".
      final String revision = change.getRevision();
      if (!StringUtils.isBlank(revision)) {
        params.setProperty("pathrev", revision);
      }
//      params.setProperty("view", "log");
      params.setProperty("view", "markup");
    }
    return makeURL(change.getFilePath(), params);
  }


  /**
   * Helper method to compose an URL based on url,
   * changeFilePath and URL parameters.
   *
   * @param changeFilePath
   * @param params
   */
  private String makeURL(final String changeFilePath, final Properties params) {
    // compose result URL
    final StringBuffer result = new StringBuffer(200);
    // REVIEWME: vimeshev - alters params, bad
    if (!StringUtils.isBlank(viewcvsRoot)) {
      params.setProperty("root", viewcvsRoot);
    }
    if (log.isDebugEnabled()) log.debug("changeFilePath: " + changeFilePath);
    result.append(url);
    result.append(url.endsWith("/") ? "" : "/");
    if (changeFilePath.length() > 0) {
      result.append(changeFilePath.charAt(0) == '/' ? changeFilePath.substring(1) : changeFilePath);
    }
    result.append(WebuiUtils.makeURLParameters(params));
    return result.toString();
  }
}

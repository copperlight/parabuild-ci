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

import java.io.*;
import org.apache.commons.logging.*;
import org.apache.lucene.document.*;
import org.apache.lucene.queryParser.*;
import org.apache.lucene.search.*;

import junit.framework.*;

import com.gargoylesoftware.base.testing.*;
import org.parabuild.ci.object.*;
import org.parabuild.ci.search.*;
import org.parabuild.ci.build.AbstractCustomLogTest;


/**
 * Tests TextDirLogHandler
 *
 * @see org.parabuild.ci.build.AbstractCustomLogTest
 */
public class SSTestHTMLDirLogHandler extends AbstractCustomLogTest {

  private static final Log log = LogFactory.getLog(SSTestHTMLDirLogHandler.class);

  private static final int TEST_IN_DIR_LOG_COUNT = 3;

  private HTMLDirLogHandler logHandler = null;


  /**
   * @see AbstractCustomLogTest#processLogs
   */
  protected void processLogs() {
    this.logHandler.process();
  }


  /**
   * @return log type handler being tested
   */
  protected byte logTypeBeingTested() {
    return LogConfig.LOG_TYPE_HTML_DIR;
  }


  /**
   * Should return ID of log config to be used to configure log
   * handler.
   */
  protected int logConfigID() {
    return 6; // directory with text files log congig ID
  }


  /**
   * Return a string to be found in search after calling
   * processLogs.
   *
   * @return
   *
   * @see AbstractCustomLogTest - parent class that will call
   *      this method after calling processLogs().
   * @see #processLogs
   */
  protected String stringToBeFoundBySearch() {
    return this.getClass().getName();
  }


  public void test_archiveFileNamesAreInSearchResultFields() throws ParseException, IOException {
    Hits results = searchManager.search(new SearchRequest(stringToBeFoundBySearch()));
    assertTrue(results.length() > 0);
    // check if required fields are there
    for (int i = 0; i < results.length(); i++) {
      final Document result = results.doc(i);
      assertFieldPresent(result, LuceneDocumentFactory.FIELD_SEQUENCE_LOG_FILE_NAME_IN_DIR);
//      if (log.isDebugEnabled()) log.debug("result.get(LuceneDocumentFactory.FIELD_SEQUENCE_LOG_FILE_NAME_IN_DIR = " + result.get(LuceneDocumentFactory.FIELD_SEQUENCE_LOG_FILE_NAME_IN_DIR));
    }

    results = searchManager.search(new SearchRequest("test log index"));
    assertTrue(results.length() > 0);
  }


  protected void setUp() throws Exception {
    super.setUp();

    // create handler
    this.logHandler = new HTMLDirLogHandler(agent, buildRunConfig,
      remoteCheckoutDir + '/' + relativeBuildDir,
      logConfig, TEST_STEP_RUN_ID);

    // create test log file to simulate presence of the log

    // create dir
    final String testBuildLogDirName = remoteBuildDirName + '/' + logConfig.getPath().trim();
    if (log.isDebugEnabled()) log.debug("testBuildLogDirName = " + testBuildLogDirName);
    agent.mkdirs(testBuildLogDirName);

    // create files in the dir
    for (int i = 0; i < TEST_IN_DIR_LOG_COUNT; i++) {
      final String testLogFileToCreate = testBuildLogDirName + '/' + "in_dir_file_" + i + ".html";
//      if (log.isDebugEnabled()) log.debug("testLogFileToCreate = " + testLogFileToCreate);
      agent.createFile(testLogFileToCreate, "test log content " + stringToBeFoundBySearch());
    }
    // create test index file needed by HTML log handler.
    agent.mkdirs(testBuildLogDirName + "/api");
    agent.mkdirs(testBuildLogDirName + "/com/meterware/servletunit/");
    final String indexFile = testBuildLogDirName + '/' + "com/meterware/servletunit/InvocationContext.html";
    if (log.isDebugEnabled()) log.debug("indexFile = " + indexFile);
    agent.createFile(indexFile, "test log index " + stringToBeFoundBySearch());
  }


  /**
   * Required by JUnit
   */
  public static TestSuite suite() {
    return new OrderedTestSuite(SSTestHTMLDirLogHandler.class,
      new String[]{
        "test_process",
        "test_archiveFileNamesAreInSearchResultFields"
      });
  }


  public SSTestHTMLDirLogHandler(final String s) {
    super(s);
  }
}

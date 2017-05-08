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
package org.parabuild.ci.versioncontrol.accurev;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parabuild.ci.build.AgentFailureException;
import org.parabuild.ci.common.StringUtils;
import org.parabuild.ci.remote.Agent;

import java.io.IOException;

/**
 * Accurev update command. A workspace should be created before issuing an update command.
 * <p/>
 *
 * @author Slava Imeshev
 * @since Feb 12, 2009 8:50:04 PM
 */
final class AccurevUpdateCommand extends AccurevCommand {

  /**
   * Logger.
   *
   * @noinspection UNUSED_SYMBOL,UnusedDeclaration
   */
  private static final Log LOG = LogFactory.getLog(AccurevUpdateCommand.class); // NOPMD
  private final String transactionNumber;


  AccurevUpdateCommand(final Agent agent, final AccurevCommandParameters parameters,
                       final String transactionNumber) throws IOException, AgentFailureException {
    super(agent, parameters);
    super.setCurrentDirectory(agent.getCheckoutDirName());
    this.transactionNumber = transactionNumber;
  }


  /**
   * Requests changes in the reverse order of transactions.
   */
  protected void preExecute() throws IOException, AgentFailureException {
    super.preExecute();
    final StringBuffer cmd = new StringBuffer(200);
    appendCommand(cmd, StringUtils.putIntoDoubleQuotes(getParameters().getExePath()));
    appendCommand(cmd, "update");
    appendCommand(cmd, "-t", transactionNumber);
    setCommand(cmd.toString());
    if (LOG.isDebugEnabled()) {
      LOG.debug("cmd: " + cmd);
    }
  }


  public String toString() {
    return "AccurevUpdateCommand{" +
            "transactionNumber='" + transactionNumber + '\'' +
            '}';
  }
}

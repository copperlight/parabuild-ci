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
package org.parabuild.ci.merge.finder.perforce;

import java.io.IOException;

import org.parabuild.ci.ServersideTestCase;

import org.parabuild.ci.build.AgentFailureException;
import org.parabuild.ci.common.BuildException;
import org.parabuild.ci.common.CommandStoppedException;
import org.parabuild.ci.merge.MergeManager;
import org.parabuild.ci.object.ActiveMergeConfiguration;
import org.parabuild.ci.object.BranchMergeConfiguration;

/**
 */
public final class SSTestP4MergeQueueUpdater extends ServersideTestCase {


  public void test_updateMergeQueue() throws IOException, CommandStoppedException, BuildException, AgentFailureException {
    final ActiveMergeConfiguration activeConfiguration = MergeManager.getInstance().getActiveMergeConfiguration(0);
    final BranchMergeConfiguration mergeConfiguration = new P4MergeConfigurationPreparer().prepare(activeConfiguration);
    final P4MergeQueueUpdater updater = new P4MergeQueueUpdater(mergeConfiguration);
    updater.updateMergeQueue();
  }


  protected void setUp() throws Exception {
    super.setUp();
  }


  public SSTestP4MergeQueueUpdater(final String s) {
    super(s);
  }
}

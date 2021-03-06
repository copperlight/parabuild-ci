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
package org.parabuild.ci.build;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 */
public class BuildScriptStartedEventImpl implements BuildScriptStartedEvent {

  private static final Log log = LogFactory.getLog(BuildScriptStartedEventImpl.class);

  private final int handle;


  public BuildScriptStartedEventImpl(final int handle) {
    this.handle = handle;
    if (log.isDebugEnabled()) log.debug("handle: " + handle);
  }


  public int getHandle() {
    return handle;
  }


  public String toString() {
    return "BuildScriptStartedEventImpl{" +
      "handle=" + handle +
      '}';
  }
}

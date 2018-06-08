/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Jamie Band (adaptation to MVStore, added multithreaded consumer support & retry delay option)
 * @author Valentin Popov
 */

/*
 *  Your custom QueueItem should extends this abstract class.
 *  Use basic fields that can be serialized using Jackson JSON.
 */

package com.stimulussoft.filequeue;

import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * FileQueueItem
 */

public abstract class FileQueueItem implements Serializable {

    private AtomicInteger retryCount = new AtomicInteger(0);
    private Date tryDate;

    public FileQueueItem() {
    }

    public Date getTryDate() {
        return tryDate;
    }

    public void setTryDate(Date date) {
        this.tryDate = date;
    }

    public int getTryCount() {
        return retryCount.get();
    }

    public void setTryCount(int tryCount) {
        Preconditions.checkArgument(tryCount >= 0, "tryCount can't be less 0");
        this.retryCount.set(tryCount);
    }

    public void incTryCount() {
        this.retryCount.incrementAndGet();
    }

    public abstract String toString();

}
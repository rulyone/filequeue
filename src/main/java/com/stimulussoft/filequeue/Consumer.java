package com.stimulussoft.filequeue;

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
 */

/**
 * Consumer
 *
 * @author Jamie Band (Stimulus Software)
 * @author Valentin Popov (Stimulus Software) */

public interface Consumer<T> {

    /**
     * Consume the given item.
     *
     * @param item the item to handle.
     * @return <code>true</code> if the item was processed successfully and shall be removed from the filequeue.
     * @throws InterruptedException if thread was interrupted due to shutdown
     */
    boolean consume(T item) throws InterruptedException;

}
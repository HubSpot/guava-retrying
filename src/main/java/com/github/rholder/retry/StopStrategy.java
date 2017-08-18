/*
 * Copyright 2012-2015 Ray Holder
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rholder.retry;

/**
 * A strategy used to decide if a retryer must stop retrying after a failed attempt or not.
 *
 * @author JB
 */
public interface StopStrategy {

    /**
     * Returns <code>true</code> if the retryer should stop retrying.
     *
     * @param failedAttempt the previous failed {@code Attempt}
     * @return <code>true</code> if the retryer must stop, <code>false</code> otherwise
     */
    default boolean shouldStop(Attempt failedAttempt) {
        return shouldStop((int) failedAttempt.getAttemptNumber(), failedAttempt.getDelaySinceFirstAttempt());
    }

    /**
     * @deprecated Override and call {@link StopStrategy#shouldStop(Attempt)} instead. This
     *             method only exists to allow backwards compatibility with version 1.
     */
    @Deprecated
    default boolean shouldStop(int previousAttemptNumber, long delaySinceFirstAttemptInMillis) {
        throw new IllegalStateException("Either shouldStop(Attempt) or shouldStop(int, long) must be overridden.");
    }
}

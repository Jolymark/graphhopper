/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.graphhopper.routing.ev;

public enum Cycleway {
    MISSING("missing"), LANE("lane"), OPPOSITE_LANE("opposite_lane"), OPPOSITE("opposite"),
    SHARED_LANE("shared_lane"), SHARE_BUSWAY("share_busway"), OPPOSITE_SHARE_BUSWAY("opposite_whare_busway"),
    SHARED("shared"), TRACK("track"), OPPOSITE_TRACK("opposite_track"), ASL("asl"),
    SHOULDER("shoulder"), SEPARATE("SEPARATE"), NO("no"), CROSSING("crossing");

    public static final String KEY = "cycleway";

    public static EnumEncodedValue<Cycleway> create() {
        return new EnumEncodedValue<>(KEY, Cycleway.class);
    }

    private final String name;

    Cycleway(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Cycleway find(String name) {
        if (name == null || name.isEmpty())
            return MISSING;

        for (Cycleway cycleway : values())
            if (cycleway.name().equalsIgnoreCase(name))
                return cycleway;

        return MISSING;
    }
}

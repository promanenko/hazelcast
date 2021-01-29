/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.impl.protocol.codec.builtin;

import com.hazelcast.client.impl.protocol.ClientMessage;

import java.util.List;

import static com.hazelcast.client.impl.protocol.codec.builtin.FixedSizeTypesCodec.LONG_SIZE_IN_BYTES;

public final class ListCNLongCodec {

    private ListCNLongCodec() {
    }

    public static void encode(ClientMessage clientMessage, Iterable<Long> items) {
        ListCNFixedSizeCodec.encode(clientMessage, items, LONG_SIZE_IN_BYTES, FixedSizeTypesCodec::encodeLong);
    }

    public static List<Long> decode(ClientMessage.ForwardFrameIterator iterator) {
        return decode(iterator.next());
    }

    public static List<Long> decode(ClientMessage.Frame frame) {
        return ListCNFixedSizeCodec.decode(frame, LONG_SIZE_IN_BYTES, FixedSizeTypesCodec::decodeLong);
    }
}

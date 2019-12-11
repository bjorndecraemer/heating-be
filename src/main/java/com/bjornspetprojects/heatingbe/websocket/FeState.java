package com.bjornspetprojects.heatingbe.websocket;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FeState {
    private FeStateType feStateType;
    private String stringValue;
    private Integer intValue;
}

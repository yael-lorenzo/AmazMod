package com.amazmod.service.events.incoming;

import com.huami.watch.transport.DataBundle;

public class LowPower {

    private DataBundle dataBundle;

    public LowPower(DataBundle dataBundle) {
        this.dataBundle = dataBundle;
    }

    public DataBundle getDataBundle() {
        return dataBundle;
    }
}

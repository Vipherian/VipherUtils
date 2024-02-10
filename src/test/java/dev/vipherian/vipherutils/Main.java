package dev.vipherian.vipherutils;

import dev.vipherian.vipherutils.cloud.CloudSystem;

public final class Main {
    public static void main(String[] args) {
        CloudSystem.setupVerification("fd3f657f-235a-4a53-ba52-ba5699c3150b");

        CloudSystem.delete("lobby");
    }
}

package dev.vipherian.vipherutils.minestom.world;

import net.minestom.server.instance.ChunkGenerator;
import net.minestom.server.instance.ChunkPopulator;
import net.minestom.server.instance.batch.ChunkBatch;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StoneGenerator implements ChunkGenerator {
    @Override
    public void generateChunkData(@NotNull ChunkBatch chunkBatch, int i, int i1) {
        byte x;
        for (x = 0; x < 16; x = (byte) (x + 1)){
            byte z;
            for (z = 0; z < 16; z = (byte) (z + 1)){
                chunkBatch.setBlock(x,40,z, Block.STONE);
            }
        }
    }

    @Override
    public @Nullable List<ChunkPopulator> getPopulators() {
        return null;
    }
}

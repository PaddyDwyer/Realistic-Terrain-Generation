package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaBirchForestHills;
import rtg.terrain.vanilla.TerrainVanillaBirchForestHills;

public class RealisticBiomeVanillaBirchForestHills extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.birchForestHills.topBlock;
	public static Block fillerBlock = BiomeGenBase.birchForestHills.fillerBlock;
	
	public RealisticBiomeVanillaBirchForestHills()
	{
		super(
			BiomeGenBase.birchForestHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaBirchForestHills(70f, 180f, 7f, 100f, 38f, 260f, 68f),
			new SurfaceVanillaBirchForestHills(topBlock, fillerBlock, topBlock, topBlock)
		);
	}	
}

package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMushroomIsland;
import rtg.terrain.vanilla.TerrainVanillaMushroomIsland;

public class RealisticBiomeVanillaMushroomIsland extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.mushroomIsland.topBlock;
	public static Block fillerBlock = BiomeGenBase.mushroomIsland.fillerBlock;
	
	public RealisticBiomeVanillaMushroomIsland()
	{
		super(
			BiomeGenBase.mushroomIsland,
			VanillaBiomes.climatizedBiome(BiomeGenBase.ocean, Climate.COLD),
			new TerrainVanillaMushroomIsland(),
			new SurfaceVanillaMushroomIsland(topBlock, fillerBlock, 67, topBlock, 0f)
		);
	}	
}

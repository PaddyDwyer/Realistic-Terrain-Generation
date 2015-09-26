package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMesaPlateau;
import rtg.terrain.vanilla.TerrainVanillaMesaPlateau;

public class RealisticBiomeVanillaMesaPlateau extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.mesaPlateau.topBlock;
	public static Block fillerBlock = BiomeGenBase.mesaPlateau.fillerBlock;
	
	public RealisticBiomeVanillaMesaPlateau()
	{
		super(
			BiomeGenBase.mesaPlateau,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaMesaPlateau(true, 35f, 160f, 60f, 40f, 69f),
			new SurfaceVanillaMesaPlateau(topBlock, fillerBlock, (byte)1, 0)
		);
	}	
}

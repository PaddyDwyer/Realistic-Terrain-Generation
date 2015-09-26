package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMesaPlateauF;
import rtg.terrain.vanilla.TerrainVanillaMesaPlateauF;

public class RealisticBiomeVanillaMesaPlateauF extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.mesaPlateau_F.topBlock;
	public static Block fillerBlock = BiomeGenBase.mesaPlateau_F.fillerBlock;
	
	public RealisticBiomeVanillaMesaPlateauF()
	{
		super(
			BiomeGenBase.mesaPlateau_F,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaMesaPlateauF(true, 35f, 160f, 60f, 40f, 69f),
			new SurfaceVanillaMesaPlateauF(topBlock, fillerBlock, (byte)1, 0)
		);
	}	
}

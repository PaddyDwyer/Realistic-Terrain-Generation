package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaSavannaPlateau;
import rtg.terrain.vanilla.TerrainVanillaSavannaPlateau;

public class RealisticBiomeVanillaSavannaPlateau extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.savannaPlateau.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.savannaPlateau.fillerBlock;
	
	public RealisticBiomeVanillaSavannaPlateau()
	{
		super(
			BiomeGenBase.savannaPlateau,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT),
			new TerrainVanillaSavannaPlateau(0f, 120f, 68f, 200f),
			new SurfaceVanillaSavannaPlateau(topBlock, fillerBlock, 300f, true, true)
		);
	}	
}

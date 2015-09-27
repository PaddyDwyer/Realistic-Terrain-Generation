package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaRiver;
import rtg.terrain.vanilla.TerrainVanillaRiver;

public class RealisticBiomeVanillaRiver extends RealisticBiomeVanilla
{	
	public static BiomeGenBase vanillaBiome = BiomeGenBase.river;
	public static IBlockState topBlock = vanillaBiome.topBlock;
	public static IBlockState fillerBlock = vanillaBiome.fillerBlock;
	
	public RealisticBiomeVanillaRiver()
	{
		super(
			vanillaBiome,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaRiver(),
			new SurfaceVanillaRiver(Blocks.sand.getDefaultState(), Blocks.sand.getDefaultState(), Blocks.grass.getDefaultState(), Blocks.grass.getDefaultState(), 0)
		);
	}	
}

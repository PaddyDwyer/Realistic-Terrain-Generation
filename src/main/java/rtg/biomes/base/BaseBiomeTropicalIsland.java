package rtg.biomes.base;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;

public class BaseBiomeTropicalIsland extends BiomeGenBase
{
	public BaseBiomeTropicalIsland(int id, String bn) 
	{
		super(id);
		setTemperatureRainfall(0.8f, 0.8f);
		setBiomeName(bn);
	}
}

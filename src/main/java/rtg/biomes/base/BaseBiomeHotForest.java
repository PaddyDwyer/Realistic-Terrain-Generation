package rtg.biomes.base;

import net.minecraft.init.Blocks;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rtg.data.VillageMaterialData;
import rtg.data.VillageMaterials;

public class BaseBiomeHotForest extends BiomeGenBase
{
	public BaseBiomeHotForest(int id, String bn) 
	{
		super(id);
		setTemperatureRainfall(0.8f, 0.2f);
		setBiomeName(bn);
		setDisableRain();
		
		VillageMaterialData vmd = new VillageMaterialData(this);
		vmd.plankBlock = Blocks.planks.getStateFromMeta(4);
		vmd.logBlock = Blocks.log2.getDefaultState();
		vmd.pathBlock = Blocks.cobblestone.getDefaultState();
		vmd.stairsWoodBlock = Blocks.acacia_stairs.getDefaultState();
		vmd.slabsBlock = Blocks.oak_fence.getDefaultState();
		VillageMaterials.registerVillageMaterial(vmd);
	}
	
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int i, int dont, int care)
    {
        return ColorizerGrass.getGrassColor(1f, 0f);
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int i, int dont, int care)
    {
        return ColorizerFoliage.getFoliageColor(0.8f, 0.2f);
    }
}

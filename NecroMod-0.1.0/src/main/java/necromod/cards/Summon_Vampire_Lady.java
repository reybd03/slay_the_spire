package necromod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import necromod.NecroMod;
import necromod.patches.AbstractCardEnum;
import necromod.powers.VampireLadyPower;
import necromod.powers.VampirePrincessPower;

public class Summon_Vampire_Lady extends AbstractNecromancerCards {
	public static String ID = "Summon_Vampire_Lady";
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID); // Fix this for upgrade
	public static String NAME = "Summon Vampire Lady";
	public String NAME2 = "Summon Vampire Princess";
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	private static final int COST = 3;
	
	public Summon_Vampire_Lady() {
		super(ID, NAME, NecroMod.makePath(NecroMod.SUMMON_VAMPIRE_LADY), COST, DESCRIPTION, AbstractCard.CardType.POWER,
				AbstractCardEnum.WHITE, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
		
	}
	
        @Override
	public void use(AbstractPlayer p, AbstractMonster m) {
                       this.baseDamage = this.damage = 8;
		
			if(this.name.equals("Summon Vampire Lady")){
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p,
                                        p, new VampireLadyPower(p, 1, this.upgraded, this.baseDamage), 1));
			}
			else {
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p,
                                        p, new VampirePrincessPower(p, 1, this.upgraded, this.baseDamage + 2), 1));		
                        }
			
	}
	
        @Override
	public AbstractCard makeCopy() {
		return new Summon_Vampire_Lady();
	}
	
        @Override
	public void upgrade() {
		if (!this.upgraded) {
			this.name = this.NAME2;
			this.upgradeName();
			this.upgradeBaseCost(1);
		}
	}

}

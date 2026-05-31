/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;

public class Loans {
    public static final boolean canTakeMoreLoans(int nCivID) {
        return CFG.core.getCiv(nCivID).getLoansSize() < GameValues.gvLoan.LOAN_MAX_NUM_OF_LOANS;
    }

    public static final void takeLoan(int iCivID, long iGold, int iDuration) {
        if (Loans.canTakeMoreLoans(iCivID) && iGold > 0 && iDuration >= GameValues.gvLoan.LOAN_MIN_DURATION && iDuration <= GameValues.gvLoan.LOAN_MAX_DURATION) {
            if (!Loans.canTakeMoreLoans(iCivID)) {
                return;
            }
            if (iGold > Loans.takeLoan_MaxValue(iCivID)) {
                iGold = Loans.takeLoan_MaxValue(iCivID);
            }
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() + iGold);
            CFG.core.getCiv(iCivID).addLoanNew((int)Math.max(Math.ceil(((double)iGold + (double)iGold * (double)Loans.takeLoan_InterestRate(iCivID, (int)iGold, iDuration) / 100.0) / (double)iDuration), 1.0), iDuration);
            CFG.core.getCiv(iCivID).setMovementPoints(CFG.core.getCiv(iCivID).getMovemPoints() - GameValues.gvLoan.COST_TAKE_LOAN);
        }
    }

    public static final int takeLoan_MinValue() {
        return GameValues.gvLoan.LOAN_MAX_DURATION;
    }

    public static final long takeLoan_MaxValue(int iCivID) {
        return (long)Math.max((float)(CFG.core.getCiv((int)iCivID).incomeTaxation + CFG.core.getCiv((int)iCivID).incomeProduction) * GameValues.gvLoan.LOAN_MAX_VALUE_BASED_ON_INCOME_MODIFIER, (float)(GameValues.gvLoan.LOAN_MIN_DURATION + GameValues.gvLoan.LOAN_MAX_DURATION));
    }

    public static final float takeLoan_InterestRate(int iCivID, long iGold, int iDuration) {
        if (iGold == 0) {
            return 0.0f;
        }
        return GameValues.gvLoan.LOAN_INTEREST_BASE_VALUE + (float)CFG.core.getCiv(iCivID).getLoansSize() * GameValues.gvLoan.LOAN_INTEREST_EXTRA_PER_LOAN + (GameValues.gvLoan.LOAN_INTEREST_BASE_PER_DURATION + (float)CFG.core.getCiv(iCivID).getLoansSize() * GameValues.gvLoan.LOAN_INTEREST_BASE_PER_DURATION_PER_LOAN) * (float)(iDuration - GameValues.gvLoan.LOAN_MIN_DURATION) / (float)(GameValues.gvLoan.LOAN_MAX_DURATION - GameValues.gvLoan.LOAN_MIN_DURATION);
    }

    public static final void repayLoan(int iCivID, int iLoanID) {
        try {
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() - (long)(CFG.core.getCiv((int)iCivID).getLoan((int)iLoanID).iTurnsLeft * CFG.core.getCiv((int)iCivID).getLoan((int)iLoanID).iGoldPerTurn));
            CFG.core.getCiv(iCivID).removeLoan(iLoanID);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void repayLoan(int iCivID, int iLoanID, int byCivID) {
        try {
            CFG.core.getCiv(byCivID).setGold(CFG.core.getCiv(byCivID).getGold() - (long)(CFG.core.getCiv((int)iCivID).getLoan((int)iLoanID).iTurnsLeft * CFG.core.getCiv((int)iCivID).getLoan((int)iLoanID).iGoldPerTurn));
            CFG.core.getCiv(iCivID).removeLoan(iLoanID);
            CFG.core.getCiv(iCivID).setRelationD(byCivID, CFG.core.getCiv(iCivID).getRelationD(byCivID) + GameValues.gvLoan.DEBT_RELIEF_RELATIONS_INCREASE);
            CFG.core.getCiv(byCivID).setRelationD(iCivID, CFG.core.getCiv(byCivID).getRelationD(iCivID) + GameValues.gvLoan.DEBT_RELIEF_RELATIONS_INCREASE);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}


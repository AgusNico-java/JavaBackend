package TechnicalInterview.demo.services;

import TechnicalInterview.demo.enums.Brand;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    
    final int TRANSACTION_MAX = 1000;
    Calendar date = new GregorianCalendar();
    final int DAY = date.get(Calendar.DAY_OF_MONTH);
    final int MONTH = date.get(Calendar.MONTH);
    final int YEAR = 23;

    /**
     * Calculates the total fee for a transaction.
     *
     * @param creditCard
     * @param transactionImport
     * @return
     */
    public float totalFee(String brand, float transactionImport) {

        return (calculateRate(brand) * transactionImport / 100);
    }

    /**
     * Calculates the percentage rate for each brand, based on the parameters
     * each one need.
     *
     * @param creditCard
     * @return
     */
    private float calculateRate(String brand) {

        if (validBrand(brand)) {
            switch (brand.toUpperCase()) {
                case "VISA":
                    return (YEAR / MONTH) * getVisaConstant();
                case "NARA":
                    return (float) (DAY * 0.5 * getNaraConstant());
                case "AMEX":
                    return (float) (MONTH * 0.1 * getAmexConstant());
            }
        } else {
            System.out.println("No se pudo encontrar la marca indicada.");
        }
        return 0f;
    }

    /**
     * Gets a constant which ensures that the rate for the VISA card will be
     * equaly split along the year, and will always be between 0.3 and 5.
     *
     * @return
     */
    private float getVisaConstant() {

        float min = (float) (3.6 / YEAR);
        float max = (float) (5 / YEAR);

        float interval = (max - min) / 12;

        float constant = min + ((12 - (MONTH + 1)) * interval);//La tasa es menor a medida que pasan los meses. Tiene su maximo en enero y su minimo en diciembre.
        return constant;
    }

    /**
     * Gets a constant which ensures that the rate for the NARA card will be
     * equaly split along the year, and will always be between 0.3 and 5.
     *
     * @return
     */
    private float getNaraConstant() {
        float min = 0.6f;
        float max = 10 / 31;

        float interval = (max - min) / 31;

        float constant = min + ((DAY - 1) * interval);//La tasa es mayor a medida que pasan los días, teniendo su minimo en el día 1 del mes y su máximo en el 31
        return constant;
    }

    /**
     * Gets a constant which ensures that the rate for the AMEX card will be
     * equaly split along the year, and will always be between 0.3 and 5.
     *
     * @return
     */
    private float getAmexConstant() {
        float min = 3f;
        float max = 50 / 12;

        float interval = (max - min) / 11;

        float constant = min + (MONTH * interval);//La tasa es mayor a medida que pasan los meses, teniendo su minimo en el mes 1 del año y su máximo en el 12
        return constant;
    }

    private boolean validBrand(String brand) {
        for (Brand cardBrand : Brand.values()) {
            if (cardBrand.toString().equalsIgnoreCase(brand)) {
                return true;
            }
        }
        return false;
    }
}

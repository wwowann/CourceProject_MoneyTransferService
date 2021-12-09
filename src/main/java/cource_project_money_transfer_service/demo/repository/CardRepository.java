package cource_project_money_transfer_service.demo.repository;

import cource_project_money_transfer_service.demo.model.AmountObject;
import cource_project_money_transfer_service.demo.model.DataCard;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class CardRepository {
    public Map<String, DataCard> dataCardMap;

    public CardRepository(Map<String, DataCard> dataCardMap) {
        this.dataCardMap = dataCardMap;
    }

    public String getDataCard(DataCard dataCard) {
        dataCardMap.put(dataCard.getVerificationCode(), dataCard);
return dataCard.getVerificationCode();
    }

    public String getVerifivationCode(String operationId){
        if (dataCardMap.containsKey(operationId)) return "Success confirmation";
        return "error";
    }

}

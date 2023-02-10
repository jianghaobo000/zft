package cdu.jhb.domain.customer.gateway;

import cdu.jhb.domain.customer.Customer;
import cdu.jhb.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}

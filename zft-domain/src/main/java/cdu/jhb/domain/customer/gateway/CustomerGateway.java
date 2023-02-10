package cdu.jhb.domain.customer.gateway;

import cdu.jhb.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}

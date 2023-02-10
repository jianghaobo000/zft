package cdu.jhb.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import cdu.jhb.dto.CustomerAddCmd;
import cdu.jhb.dto.CustomerListByNameQry;
import cdu.jhb.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}

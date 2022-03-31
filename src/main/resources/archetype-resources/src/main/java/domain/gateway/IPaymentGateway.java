/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.gateway;

import ${package}.domain.entity.EPayment;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IPaymentGateway {

     /**
      *
      * @param ePayment
      * @return
      */
     Uni<EPayment> save(final EPayment ePayment);

     /**
      *
      * @param id
      * @param ePayment
      * @return
      */
     Uni<EPayment> update(final Long id, final EPayment ePayment);

     /**
      *
      * @param id
      * @return
      */
     Uni<Boolean> delete(final Long id);

     /**
      *
      * @param id
      * @return
      */
     Uni<EPayment> getById(final Long id);

     /**
      *
      * @return
      */
     Uni<List<EPayment>> getAll();
}

package com.clouway.jobex.inject;

import com.google.inject.Injector;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class JobExConstraintValidatorFactory implements ConstraintValidatorFactory {

  private final Injector injector;

  public JobExConstraintValidatorFactory(Injector injector) {
    this.injector = injector;
  }

  public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> tClass) {
    return injector.getInstance(tClass);
  }
}

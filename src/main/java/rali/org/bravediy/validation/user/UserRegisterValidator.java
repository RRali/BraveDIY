//package rali.org.bravediy.validation.user;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.Errors;
//import rali.org.bravediy.data.models.UserRegisterBindingModel;
//import rali.org.bravediy.validation.ValidationConstants;
//import rali.org.bravediy.validation.annotation.Validator;
//
//
//import java.lang.annotation.Annotation;
//
//@Validator
//public class UserRegisterValidator implements Validator {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserRegisterValidator(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return UserRegisterBindingModel.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        UserRegisterBindingModel userRegisterBindingModel = (UserRegisterBindingModel) o;
//
//        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
//            errors.rejectValue(
//                    "username",
//                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername()),
//                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername())
//            );
//        }
//
//        if (userRegisterBindingModel.getUsername().length() < 3 || userRegisterBindingModel.getUsername().length() > 10) {
//            errors.rejectValue(
//                    "username",
//                    ValidationConstants.USERNAME_LENGTH,
//                    ValidationConstants.USERNAME_LENGTH
//            );
//        }
//
//        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
//            errors.rejectValue(
//                    "password",
//                    ValidationConstants.PASSWORDS_DO_NOT_MATCH,
//                    ValidationConstants.PASSWORDS_DO_NOT_MATCH
//            );
//        }
//
//        if (this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
//            errors.rejectValue(
//                    "email",
//                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail()),
//                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail())
//            );
//        }
//    }
//
//    @Override
//    public String value() {
//        return null;
//    }
//
//    @Override
//    public Class<? extends Annotation> annotationType() {
//        return null;
//    }
//}

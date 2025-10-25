package Eretail.FrameworkEretail.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListeners implements IAnnotationTransformer{
	// In this code we are taking help from IAnnotationTransformer and IRetryAnalyzer for running failer test cases for 
		// 3 times by transforms method
		//async wait for the till the response
		public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
			
			annotation.setRetryAnalyzer(RetryAnalyser.class);
		}


}

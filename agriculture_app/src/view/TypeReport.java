package view;

import constants.ConstantsLanguage;
import general.HandlerLanguage;

public enum TypeReport {
	
			REPORT_TYPE_HARV(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_HARV)),
			REPORT_TYPE_PLAN(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_PLAN)), 
			REPORT_FILTER(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_FILTER));
			
			private final String name;
			
			private TypeReport(String name) {
				this.name = name;
			}

			public String toSpanish() {
				return name;
			}
			
			@Override
			public String toString() {
				return toSpanish();
			}

}

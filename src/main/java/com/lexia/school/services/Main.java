package com.lexia.school.services;

import com.lexia.school.LexiaSchoolRankingApplication;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverName ="NO-VALUE";
		
		switch (args.length) {
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;
			default:
				usage();
				return;
		}
		
		if(serverName.equals("schoolRankingServer")||serverName.equals("LexiaSchoolRankingApplication")) {
			LexiaSchoolRankingApplication.main(args);
			
		}else {
			System.out.println("Unknown server type:" + serverName);
			usage();
		}
	}

	private static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println("  where server-name is 'schoolRankingServer', " + " and server- port > 3333");
		
	}

}

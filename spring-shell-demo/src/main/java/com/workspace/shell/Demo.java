package com.workspace.shell;

import org.springframework.stereotype.Component;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;

/**
 * Created by deepak.barr on 25/04/15.
 */


@Component
public class Demo implements CommandMarker {

    @CliCommand(value = "echo", help = "Echo a message")
    public String echo(
            @CliOption(key = { "", "msg" }, mandatory = true, help= "The message to echo") String msg) {
        return "This is spring shell demo  :" + msg;
    }

}
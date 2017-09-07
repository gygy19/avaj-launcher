# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: jguyet <jguyet@student.42.fr>              +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2016/03/25 15:18:38 by jguyet            #+#    #+#              #
#    Updated: 2017/03/19 04:47:40 by jguyet           ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

STUDENT		=	jguyet

PROG1		=	avaj-launcher.jar

NAMEBASE    =   $(shell basename $(PROG1) .a)

LENGTHNAME	=	`printf "%s" $(NAMEBASE) | wc -c`

MAX_COLS	=	$$(echo "$$(tput cols)-21-$(LENGTHNAME)"|bc)

JAVAC		=	javac

JAR			=	jar

FLAGS		=	cvfm

MANIFEST	=	MANIFEST.MF

SRCDIR		=	

SRCSPROG1	=	\
				com/simulator/Main.java														\
				com/simulator/aircraft/Interface/Flyable.java								\
				com/simulator/aircraft/AirCraft.java										\
				com/simulator/aircraft/AirCraftFactory.java									\
				com/simulator/aircraft/coordinates/Coordinates.java							\
				com/simulator/aircraft/flyable/Baloon.java									\
				com/simulator/aircraft/flyable/Helicopter.java								\
				com/simulator/aircraft/flyable/JetPlane.java								\
				com/simulator/enums/AirCraftEnum.java										\
				com/simulator/enums/WeatherEnum.java										\
				com/simulator/observatory/Tower.java										\
				com/simulator/observatory/WeatherTower.java									\
				com/simulator/provider/WeatherProvider.java									\
				com/simulator/utils/Utils.java

DSRCSPROG1	=	$(addprefix $(SRCDIR), $(SRCSPROG1))

CLASSPROG1	=	$(addprefix $(SRCDIR), $(SRCSPROG1:.java=.class))

.SILENT:

all:
	if test -f $(PROG1) ; then																\
		echo "make: Nothing to be done for \`all\`.";										\
	else																					\
		$(MAKE) -j $(STUDENT);																\
	fi

$(STUDENT):
	$(MAKE) $(PROG1)

$(PROG1):
	cp -r src/com com
	$(JAVAC) $(DSRCSPROG1)
	$(JAR) $(FLAGS) $(PROG1) $(MANIFEST) $(CLASSPROG1)
	echo "MAKE    [$(PROG1)]"
	echo "\033[38;5;227mAUTHOR  :\033[0m"
	cat auteur

clean:
	echo -en "\r\033[38;5;101mCLEAN  "														\
		"[\033[0m$(NAMEBASE)\033[38;5;101m]\033[K\033[0m";
	rm -rf $(CLASSPROG1)
	rm -rf com

fclean:
	echo -en "\r\033[38;5;101mFCLEAN  "														\
		"[\033[0m$(NAMEBASE)\033[38;5;101m]\033[K\033[0m";
	rm -rf $(CLASSPROG1)
	rm -rf $(PROG1)

re: fclean all
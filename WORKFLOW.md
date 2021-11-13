# Workflow

This file contains instructions aimed to streamline the structure of the team workflow and improve project organization.

## Git

### Commits

First and foremost, commit early and often. Each commit should ideally correspond to one task done. A good metric is that, if you find yourself writing "and" in your commits a lot, try to split them further into smaller commits. Do keep in mind that each commit should still form a meaningful unit, so do not include in your commit unfinished lines of code.

Write meaningful commit messages. Some guidelines that each team member should follow on writing commit messages are:

1. Begin your commit message with a (capitalized) present-tense imperative verb.

   In other words, do not add the suffixes "-s", "-ed", or "-ing", etc.

2. Write no more than 50 characters on the subject line.

3. Do not append a period at the end (leave it like this ->)

4. Write an additional commit body if clarification is needed.

Adding a commit body can be easily done in IntelliJ. Simply separate the message and body with a blank line. Here is a sample commit message:

```
Implement getUser in UserDatabase
```

### Merging

If you and another team member are working on the same branch, it is likely that at some point you will need to pull new changes introduced by your teammate into your local repo, but you have already made commits yourself. In this case, if you pull regardless, by default Git will create a merge commit. It will look something like the following:

```
* 26124ab (HEAD -> main) Merge branch 'main' of https://github.com/username/A into main
|\
| * d3fcb3b (origin/main) Add a line	<- this is your teammate's commit
* | df10aea Add a file					<- this is your commit
|/
* d6f5f6a Add a file					<- this is the common parent commit
```

Some IDEs may warn you over this, but some may not. These merge commits do not serve much of a purpose other than reconciling two commit histories. Therefore, it is best to avoid such merge commits by doing `git pull --rebase` instead of a simple `git pull`. Most IDEs should have both of these options in their GUI.

You may not be informed every time your team pushes into the remote repo. Having to check with everyone if it is "OK" to push is time-consuming. Rather, check `git status` before you pull. Furthermore, always pull before you push.

### Branching

*Never* do any significant work directly on the main branch. Create your own branch, and give it an indicative name. *Do not* simply put your name as the branch name. We will not be following any complex naming conventions, but I offer some recommendations just for the sake of consistency:

1. Use all lowercase.
2. Separate words with hyphens.

The point of making a branch is not so that you will just work on it indefinitely and merge everything back into `main` all at once. For now, we will follow the simple guideline of one feature per branch. Only merge into `main` after running all the tests and making sure they pass.

## Code

### Documentation

If the purpose of a function isn't immediately clear, by which I mean anything beyond a simple getter/setter, you should always put Javadoc before it. Document as you go. There isn't a clear length guideline, but keep the summary (first line) concise. If more information needs to be included, start a separate paragraph. Remember to manually line-break.

Here is an example:

```java
/**
* Returns the {@code k}th prime number.
*
* <p>This function uses memoization and a sieve.
*
* @param k ...
* @return ...
*/
public int getPrime(int k);
```

Unlike Git, Java documentation usually starts off with a third-person singular verb.

### Formatting

For Visual Studio Code, we will be using the rules defined in `eclipse-formatter.xml`. Look for `Java: Open Java Formatter Settings with Preview`.

### Best Practices

#### Polymorphism

Prefer type declarations with interface/super class types like `List` instead of specific implementations such as `ArrayList`, `LinkedList`, etc., since in the majority of cases the client code does not need to know the exact type. Do this:

```java
List<Integer> lst = new ArrayList<>();
```

instead of this:

```java
ArrayList<Integer> lst = new ArrayList<Integer>();
```

Also note that Java allows you to skip the type declaration on the right hand side so that you don't have to repeat the type. However, careful that you *cannot* skip typing the diamond operator `<>`, for reasons tied with backwards compatibility and raw vs. generic types.


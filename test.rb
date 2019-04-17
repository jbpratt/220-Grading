describe 'database' do
  def run_script(commands)
    raw_output = nil
    IO.popen("./sum", "r+") do |pipe|
      commands.each do |command|
        pipe.puts command
      end

      pipe.close_write

      # Read entire output
      raw_output = pipe.gets(nil)
    end
    raw_output.split("\n")
  end

  it 'sums two strings' do
    result = run_script([
      "insert",
    ])
    expect(result).to match_array([
      "Enter First String: ",
      "insert",
    ])
  end
end

